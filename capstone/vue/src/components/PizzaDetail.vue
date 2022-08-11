<template>
  <div>
    <div class="loading" v-if="isLoading">
      <img src="../assets/pizza_loader.gif" />
    </div>
    <div v-else>
      <h1>{{ pizza.id }}</h1>
      <p>{{ pizza.description }}</p>
      <!-- <router-link
        tag="button"
        :to="{ name: 'EditCard', params: {cardID: $route.params.cardID} }"
        class="btn editCard"
      >Edit Card</router-link> -->
      <button class="btn deletePizza" v-on:click="deletePizza">Delete Pizza</button>
      <div class="status-message error" v-show="errorMsg !== ''">{{errorMsg}}</div>
      <comments-list :comments="pizza.comments" />
    </div>

    <div class="board-actions" v-if="!isLoading">
      <router-link :to="{ name: 'Board', params: { id: $route.params.boardID } }">Back to Board</router-link>
    </div>
  </div>
</template>

<script>
import pizzaService from "../services/PizzaService";
// import CommentsList from "@/components/CommentsList";

export default {
  name: "pizza-detail",
  components: {
    // CommentsList
  },
  data() {
    return {
      isLoading: true,
      errorMsg: "",
    };
  },
  methods: {
    retrievePizza() {
      pizzaService
        .getPizza(this.$route.params.cardID)
        .then(response => {
          this.$store.commit("SET_CURRENT_CARD", response.data);
          this.isLoading = false;
        })
        .catch(error => {
          if (error.response && error.response.status === 404) {
            alert(
              "Card not available. This card may have been deleted or you have entered an invalid card ID."
            );
            this.$router.push({ name: 'Home' });
          }
        });
    },
    deleteCard() {
      if (
        confirm(
          "Are you sure you want to delete this card? This action cannot be undone."
        )
      ) {
        pizzaService
          .deletePizza(this.card.id)
          .then(response => {
            if (response.status === 200) {
              alert("Card successfully deleted");
              this.$router.push(`/board/${this.card.boardId}`);
            }
          })
          .catch(error => {
            if (error.response) {
              this.errorMsg =
                "Error deleting card. Response received was '" +
                error.response.statusText +
                "'.";
            } else if (error.request) {
              this.errorMsg =
                "Error deleting card. Server could not be reached.";
            } else {
              this.errorMsg =
                "Error deleting card. Request could not be created.";
            }
          });
      }
    },
  },
  created() {
    this.retrievePizza();
  },
  computed: {
    pizza() {
      return this.$store.state.pizza;
    }
  }
};
</script>

<style>
.btn.editCard {
  color: #fff;
  background-color: #508ca8;
  border-color: #508ca8;
  margin-bottom: 10px;
}
.btn.deletePizza {
  color: #fff;
  background-color: #ef031a;
  border-color: #ef031a;
  margin-bottom: 10px;
}
</style>
