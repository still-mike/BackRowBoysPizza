<template>
  <div id="test">
    <h1>Our Specialties</h1>
    <h2>no substitutions</h2>
    <button v-on:click.prevent="addPizzaToOrder">add selection to order</button>
    <button v-on:click.prevent="createOrder">place order</button>
    <div class="running-total">
        <p>Current order total: ${{ orderTotal }}</p>
        <input v-model="email" placeholder="please enter your email" />
        <input v-model="address" placeholder="please enter your address" />
    </div>
    
    
    <form v-on:submit.prevent>
    <div class="pizza-box" v-if="!isLoading">
        <!-- <form v-on:submit.prevent> -->
            
            <div class="pizza-button" v-for="visiblePizza in visiblePizzas"
                v-bind:key="visiblePizza.description" 
            >
                <h3>{{ visiblePizza.description }}</h3>
                <p>{{ visiblePizza.pizzaPrice }}</p>
                <input type="checkbox" v-model="selectedPizzas"  :value="visiblePizza"/>
                    
            </div>
            
                

        <!-- </form> -->
        
    
    </div>
    </form>

  </div>
</template>

<script>
import PizzaService from "@/services/PizzaService.js"

export default {
    name: 'test-component',
    data() {
        return {
                        
            address: "",
            email: "",
            orderTotal: 0,
            selectedPizzas: [],
            submittedPizzas:[],
            isLoading: true,
            
            order: {
                orderStatus: "Pending",
                employeeName: "",
                orderTime: null,
                custAddress: "",
                custEmail: "",
                pizzas: []
            },

        }
    },
    
    methods: {
        retrieveSpecialtyPizzas() {
            PizzaService.getSpecialtyPizzas().then((response) => {

              this.$store.commit("SET_SPECIALTY_PIZZAS", response.data);
              this.isLoading = false;              
      })
        },

        addPizzaToOrder() {
            for (let i = 0; i < this.selectedPizzas.length; i++) {
                this.order.pizzas.push(this.selectedPizzas[i]);
                this.orderTotal += this.selectedPizzas[i].pizzaPrice;
                console.log("pizza added")
      }
        },            
            
        createOrder() {
            console.log("In createOrder")
            this.order.custEmail = this.email;
            this.order.custAddress = this.address;
            if (this.order.custEmail != "") {
                console.log("has email")
                PizzaService.createOrder(this.order).then(() =>{
                //TO DO - check response - look for 201
                console.log("Order created.")
                this.order.pizzas=[];
                this.orderTotal = 0;
                this.selectedPizzas = [];
                this.submittedPizzas = [];
                console.log("Order created")
                })
            }
        },
// ===========================================================================
// ======================== ALERT example from kanban ========================
// ===========================================================================
//
// deleteBoard() {
//       if (confirm("Are you sure that you really want to delete this board?")) {
//         boardsService
//           .deleteBoard(this.boardId)
//           .then((response) => {
//             if (response.status === 200) {
//               alert("Board was successfully deleted");
//               this.$store.commit("DELETE_BOARD", this.boardId);
//               this.$router.push({ name: "Home" });
//             }
//           })

        },

    computed: {
      visiblePizzas() {
      let visiblePizzas = this.$store.state.specialtyPizzas.filter( pizza => pizza.boardId == 5 )
      // return this.$store.state.filter(())
      return visiblePizzas
    },

    },
    
    created() {
      this.retrieveSpecialtyPizzas();
    }
}
</script>


<style scoped>

#test {
  font-family: 'Major Mono Display', monospace;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

/* body {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr
} */
.pizza-box {
  height: 100vh;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-rows: 1fr 1fr 1fr;
  gap: 20px;
  align-items: stretch; /* this is the default */
}

.pizza-button{
   font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto,
    'Helvetica Neue', Arial, 'Noto Sans', sans-serif, 'Apple Color Emoji',
    'Segoe UI Emoji', 'Segoe UI Symbol', 'Noto Color Emoji';
    background: #fff;
    border-radius: 0.25rem;
    padding: 10px;
    border: 1px;
    box-shadow: 0 1px 3px 0 rgba(0, 0, 0, 0.1), 0 1px 2px 0 rgba(0, 0, 0, 0.06);
    margin-bottom: 10px;
   
}
</style>