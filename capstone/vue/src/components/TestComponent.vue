<template>
  <div id="test">
    <h1>Our Specialties</h1>
    <h2>no substitutions</h2>
    <button v-on:click.prevent="addPizzaToOrder">add selection to order</button>
    <button v-on:click.prevent="createOrder">place order</button>
    <div class="running-total">
        <p>Current order total: ${{ orderTotal }}</p>
    </div>
    <div class="pizza-box" v-if="!isLoading">
        <form v-on:submit.prevent>

            <div class="pizza-button" v-for="specialtyPizza in this.$store.state.specialtyPizzas"
                v-bind:key="specialtyPizza.description" 
            >
                <h2>{{ specialtyPizza.description }}</h2>
                <input type="checkbox" v-model="selectedPizzas"  :value="specialtyPizza"/>
                    
            </div>
            
                

        </form>
        
        
        
        
        
        
    <!-- <div class="standard-topping-list">
        <h2>choose standard toppings</h2>
        <p>first 4 are free. additional toppings ($0.25) each</p>
        <ul>
          <li v-for="standardIngredient in standardIngredients" v-bind:key="standardIngredient.ingredientName">            
            <input type="checkbox" v-model="selectedStandardIngredients"  :value="standardIngredient"/>
          {{ standardIngredient.ingredientName }}
          </li>
        </ul>      
    </div> -->
        
        
        <!-- <div
        class="pizza-button"
        v-for="specialtyPizza in this.$store.state.specialtyPizzas"
        v-bind:key="specialtyPizza.id"
        
        >
        <h2>{{ specialtyPizza.description }}</h2>
        <h3>{{ specialtyPizza.pizzaPrice }}</h3>
        <h3>Wow! only available in {{ specialtyPizza.pizzaSize }}!</h3>
        
        <form v-on:submit.prevent>
        <input type="checkbox" v-bind="this.selectedPizzas" :value="specialtyPizza"/>
        <button v-on:click.prevent="addPizzaToOrder">add one of these</button>
        
        </form>
        
        </div>     -->
    
    </div>


  </div>
</template>

<script>
import PizzaService from "@/services/PizzaService.js"

export default {
    name: 'test-component',
    data() {
        return {
            
            orderTotal: 0,
            selectedPizzas: [],
            submittedPizzas:[],
            isLoading: true,
            
            order: {
                orderStatus: "Pending",
                isDelivery: false,
                custEmail: "test@email.com",
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
      
        
        PizzaService.createOrder(this.order).then(() =>{
        //TO DO - check response - look for 201
        console.log("Order created.")
        this.order.pizzas=[];
        this.orderTotal = 0;
        this.selectedPizzas = [];
        this.submittedPizzas = [];
        
      })

    }
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