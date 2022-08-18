<template>
  <div>
    <div class="header">
      <h1>{{ title }}</h1>
      <!-- <router-link
        tag="button"
        class="btn addNewOrder"
        :to="{ name: 'AddCard', params: { boardID: this.boardId } }"
        v-if="!isLoading"
        >Define New Pizza</router-link
      > -->
      <!-- <button
        class="btn btn-cancel clearAllOrders"
        v-if="!isLoading"
        v-on:click="clearAllOrders"
      >
        Clear All Orders
      </button> -->
    </div>
        
    <div class="loading" v-if="isLoading">
      <img src="../assets/pizza_loader.gif" />
    </div>
    <div v-else>
      <div class="status-message error" v-show="errorMsg !== ''">
        {{ errorMsg }}
      </div>
      <div class="boards">
        

        <board-column v-if="isBoardColumnsDisplayed"
          title="Pending"
          :pizzas="pending"
          :boardID="this.boardId"
        />
        <board-column v-if="isBoardColumnsDisplayed"
          title="Ready"
          :pizzas="ready"
          :boardID="this.boardId"
        />
        <board-column v-if="isBoardColumnsDisplayed"
          title="Completed"
          :pizzas="completed"
          :boardID="this.boardId"
        />
        <board-column v-if="isBoardColumnsDisplayed"
          title="Cancelled"
          :pizzas="cancelled"
          :boardID="this.boardId"
        />
      </div>
    </div>
  </div>
</template>

<script>
import pizzaService from "../services/PizzaService";
import BoardColumn from "@/components/BoardColumn";

export default {
  name: "employee-orders-list",
  components: {
    BoardColumn,
  },
  props: {
    boardId: {
      type: Number,
      default: 0,
    },
  
  },

  data() {
    return {
      
      title: "",
      isLoading: true,
      errorMsg: "",
      // status: "",
    };
  },
  methods: {
    retrievePizzas() {
      
      if (this.boardId == 1) {
      
        pizzaService.getAllPizzas()
        .then( ( response ) => {
          this.title = response.data.title;
          let allPizzas = response.data;          
          this.$store.commit("SET_BOARD_PIZZAS", allPizzas);
          // this.$store.commit("SET_BOARD_PIZZAS", allPizzas);
          this.isLoading = false;
        })

      } else if (this.boardId == 2) {
      
        pizzaService.getSpecialtyPizzas()
        .then( ( response ) => {
          this.title = response.data.title;
          let specialtyPizzas = response.data;
          this.$store.commit("SET_BOARD_PIZZAS", specialtyPizzas);
          this.isLoading = false;
        })
      // pizzaService
      //   .getPizzas(this.boardId)
      //   .then((response) => {
      //     this.title = response.data.title;
      //     this.$store.commit("SET_BOARD_PIZZAS", response.data.pizzas);
      //     this.isLoading = false;
      //   })
      //   .catch((error) => {
      //     if (error.response && error.response.status === 404) {
      //       alert(
      //         "Board pizzas not available. This board may have been deleted or you have entered an invalid board ID."
      //       );
      //       this.$router.push({ name: "employee-home" });
      //     }
      //   });
    }},
    clearAllOrders() {
      if (confirm("Do you seriously want to clear all order items?")) {
        pizzaService
          .deleteBoard(this.boardId)
          .then((response) => {
            if (response.status === 200) {
              alert("Board was successfully deleted");
              this.$store.commit("DELETE_BOARD", this.boardId);
              this.$router.push({ name: "employee-home" });
            }
          })
          .catch((error) => {
            if (error.response) {
              this.errorMsg =
                "Error deleting board. Response received was '" +
                error.response.status +
                "'.";
            } else if (error.request) {
              this.errorMsg =
                "Error deleting board. Server could not be reached.";
            } else {
              this.errorMsg =
                "Error deleting board. Request could not be created.";
            }
          });

        //  console.log("!!! board id = " + this.$route.params.id)
        //  console.log("!!! boardId = " + this.boardId)
      }
    },
  },
  created() {
    
    this.retrievePizzas();
  },
  computed: {
    
    orderedPizzas() {
      let orderedPizzas = this.$store.state.orderedPizzas
      return orderedPizzas.sort((a, b) => a.orderId.localeCompare(b.orderId));
    },
    
    isBoardColumnsDisplayed() {
            return this.$store.state.showBoardColumns
    },
    
    pending() {
      return this.$store.state.boardPizzas.filter(
        (pizza) => pizza.status === "Pending"
      );
    },
    ready() {
      return this.$store.state.boardPizzas.filter(
        (pizza) => pizza.status === "Ready"
      );
    },
    completed() {
      return this.$store.state.boardPizzas.filter(
        (pizza) => pizza.status === "Completed"
      );
    },
    cancelled() {
      return this.$store.state.boardPizzas.filter(
        (pizza) => pizza.status === "Cancelled"
      );
    }
  },
};
</script>

<style>
.boards {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 20px;
}
.board-actions {
  text-align: center;
  padding: 20px 0;
}
.board-actions a:link,
.board-actions a:visited {
  color: blue;
  text-decoration: none;
}
.board-actions a:hover {
  text-decoration: underline;
}
.btn.addNewPizza {
  color: #fff;
  background-color: #508ca8;
  border-color: #508ca8;
}
.header {
  display: flex;
  align-items: center;
  justify-content: space-around;
}
.header h1 {
  flex-grow: 1;
}
</style>