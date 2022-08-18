<template>
  <div id="test">
    <successful-order-popup v-if ="displayPopup"/>
    <h1 id="OurSpecialties">our specialties</h1>
    <h2 id="NoSubstitutions">no substitutions</h2>

  <div class='BTTNS'>
         <input v-model="order.isDelivery" type="radio" id="PickupRadio" name="PickupOrDeliveryRadio" value="false">
          <label for="PickupRadio">pickup</label>
          <input v-model="order.isDelivery" type="radio" id="DeliveryRadio" name="PickupOrDeliveryRadio" value="true">
          <label for="DeliveryRadio">delivery</label>
      </div>

<!-- tomato background div
==========================
    <div id="CustomBG">  
==========================
-->      

    <button v-on:click.prevent="addPizzaToOrder">add selection to order</button>
    <button v-on:click.prevent="createOrder">place order</button>
    <div class="running-total">
        <p>current order total: ${{ orderTotal }}</p>
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
                  <!-- <ul>
                    <li v-for="ingredient in this.visiblePizza.ingredients" v-bind:key="ingredient.ingredientName" :value="standardIngredient">            
                      
                      {{ ingredient.ingredientName }}
                    </li>
                  </ul>   -->
                <!-- <ingredients-list :ingredients="pizza.ingredients" /> -->
                <input type="checkbox" v-model="selectedPizzas"  :value="visiblePizza"/>
                    
            </div>
        <!-- </form> -->

    
    </div>
    
    
    
    </form>
</div>
    

  <!-- tomato background div   
    ========================== 
    </div> 
    ==========================
    -->

  
</template>

<script>
import PizzaService from "@/services/PizzaService.js"

import SuccessfulOrderPopup from "./SuccessfulOrderPopup.vue"

export default {
    name: 'test-component',
    data() {
        return {
            
          
            displayPopup: false,
            address: "742 Evergreen Terrace",
            email: "Backrowboyzpizza@gmail.com",
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
    components: {
              
              SuccessfulOrderPopup
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
                PizzaService.createOrder(this.order).then((response) =>{
                  if (response.status === 201) {
                    alert("Pizza coming right up!");
                      console.log("Order created.")
                      this.order.pizzas=[];
                      this.orderTotal = 0;
                      this.selectedPizzas = [];
                      this.submittedPizzas = [];
                      this.email = "";
                      this.address = "";
                      console.log("Order created");
                      this.displayPopup = true;
                  }
                })
                // TO DO - check response - look for 201
                // console.log("Order created.")
                // this.order.pizzas=[];
                // this.orderTotal = 0;
                // this.selectedPizzas = [];
                // this.submittedPizzas = [];
                // this.email = "";
                // this.address = "";
                // console.log("Order created");
                // this.displayPopup = true;
                // })
            }
        },


        },

    computed: {
      visiblePizzas() {
      let visiblePizzas = this.$store.state.specialtyPizzas.filter( pizza => pizza.boardId == 5 )
      // return this.$store.state.filter(())
      return visiblePizzas
    },
    pizza() {
      return this.$store.state.pizza;
    }

    },
    
    created() {
      this.retrieveSpecialtyPizzas();
    }
}
</script>


<style scoped>

#CustomBG {
  background-image: URL("https://images.unsplash.com/photo-1624821588855-a3ffb0b050ff?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80");
  height: 100%;
  padding: 10px;

}

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

#OurSpecialties {
    display: block;
    font-size: 2em;
    margin-block-start: 0.67em;
    margin-block-end: 0.67em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    font-weight: bold;
    text-align: center;
}

#NoSubstitutions {
    display: block;
    font-size: 1em;
    margin-block-start: 0.67em;
    margin-block-end: 0.67em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    font-weight: bold;
    text-align: center;
}

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