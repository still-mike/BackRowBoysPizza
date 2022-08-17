<template>
<div>

<form v-on:submit.prevent>

     <!-- PICKUP or DELIVERY 

    <div class='BTTNS'>
        <button tag="button" class="PickupDelivery">Pickup</button>
        <button tag="button" class="PickupDelivery">Delivery</button>
      </div>

       <button
        class="btn Pickup"
        v-if="!isLoading && !addToPickUp"
        v-on:click="addToPickUp"
      >
        Pickup
      </button>
    </div>
    <div>
      <button
        
        class="btn Delivery"
        v-on:click.prevent=showForm

        >
      Delivery
    </button> 


    <form v-on:submit.prevent="addDeliveryInfo" v-if="showAddDeliveryInfo === true">
      <div class="form-element">
        <label for="name">name:</label>
        <input id="name" type="text" v-model="newDeliveryInfo.name" />
      </div>
      <div class="form-element">
        <label for="email">email:</label>
        <input id="email" type="text" v-model="newDeliveryInfo.email" />
      </div>
      <div class="form-element">
        <label for="address">address:</label>
        <input id="address" type="text" v-model="newDeliveryInfo.address" />
      </div>
      <div class="form-element">
        <label for="cardNumber">credit card number:</label>
        <input id="cardNumber" type="text" v-model="newDeliveryInfo.cardNumber" />
      </div>
      <input type="submit" value="Save" />
      <input type="button" value="Cancel" v-on:click.prevent="resetForm" />
     </div>
        -->

  <div class="MenuSelections">
  <h1 id="CreateYourOwn">create-your-own</h1>

  
  12" small ($11.99) | 16" medium ($14.99) | 20" ($17.99)
  
    <div class="pizza-size-list">
      <h2>choose a size</h2>
    <select v-model="pizza.pizzaSize" >
      <option disabled value="">please select one</option>
      <option>12" Small</option>
      <option>16" Medium</option>
      <option>20" Large</option>
      </select>
    </div>
    
    <div class="dough-list">
      <h2>choose a dough</h2>
    <select v-model="pizza.dough" >
      <option disabled value="">Please select one</option>
      <option>Hand-tossed traditional</option>
      <option>Gluten-free (+$3.50)</option>
      <option>Cauliflower, <em>vegan</em> (+$3.50)</option>
      </select>
    </div>

    <div class="style-list">
      <h2>choose a style</h2>
    <select v-model="pizza.shape" >
      <option disabled value="">Please select one</option>
      <option>Classic pie</option>
      <option>Flatbread</option>
      <option>Deepdish (+$2.50)</option>
      </select>
    </div>

    <div class="sauce-list">
      <h2>choose a sauce</h2>
    <select v-model="pizza.sauceType" >
      <option disabled value="">Please select one</option>
      <option>Traditional red</option>
      <option>White garlic</option>
      <option>Basil pesto</option>
      <option>Spicy buffalo</option>
      </select>
    </div>

    <div class="standard-topping-list">

    
        <h2>choose standard toppings</h2>
        <p>select up to (4) | additional toppings ($0.25) each<p>
        <div>
            <select v-model="selected" multiple>            
                <option v-for="availableIngredient in this.$store.state.availableIngredients" 
                        :value="availableIngredient" v-bind:key="availableIngredient.ingredientName">
                    {{ availableIngredient.ingredientName }}
                </option>               
            </select>
        </div>
    </div>
     
     
     <div class="premium-topping-list">

       
      <h2>choose premium toppings</h2>
      select up to (2) | additional toppings ($0.50) each
      <ul>
        <li v-for="premiumTopping in filteredPremiumToppings" v-bind:key="premiumTopping.choice"
            v-bind:class="{ finished: premiumTopping.done }">
          <input type="checkbox" v-model="premiumTopping.done" />
          {{ premiumTopping.choice }}
        </li>
      </ul>
    </div>
     <div>
    <button v-on:click.prevent="createOrder">Submit</button>
  </div>
</form>
</div>
</template>

<script>
// vanilla JS from Josh to select from an array
// Array.from(document.querySelectorAll("input[type=checkbox][name=type]:checked"), e => e.value); 

import PizzaService from "@/services/PizzaService.js"

export default {
   name: 'custom-pizza-form',
     data() {
    return {

      selected: [],
      
      // SELECTED AND INGREDIENT ARE NOT TALKING TO EACH OTHER YET
      
      ingredient: {
        "id": 1,
        "ingredientName": "Red onion",
        "tier": "Standard",
        "ingredientPrice": 0.25,
        "available": true
      },

      
      pizza: {
        "pizzaSize": "Large",
        "dough": "Traditonal",
        "shape": "round",
        "sauceType": "red",
        "description": "This is a test",
        "pizzaPrice": 15,
        "isSpecialty": false,
        "orderId": 0,
        "ingredients": [],
        "isAvailable": true,
        "status": "Pending"
        

      },

      order: {
        orderStatus: "Pending",
        isDelivery: false,
        custEmail: "test@email.com",
        pizzas: []
      },

      filterSizes: '',
      sizes: [
        {
          choice: '12" small',
          done: false
        },
        {
          choice: '16" medium',
          done: false
        },
        {
          choice: '20" large',
          done: false
        }
      ],

    filterDoughs: '',
    doughs: [
        {
          choice: 'hand-tossed traditional',
          done: false
        },
        {
          choice: 'gluten-free (+$3.50)', // plus $3.50 upcharge
          done: false
        },
        {
          choice: 'cauliflower, vegan (+$3.50)', // plus $3.50 upcharge
          done: false
        },
      ],

      filterStyles: '',
      styles: [
        {
          choice: 'classic pie',
          done: false
        },
        {
          choice: 'flatbread', 
          done: false
        },
        {
          choice: 'deepdish (+$2.50)', // plus $2.50 upcharge
          done: false
        },
      ],

      filterSauces: '',
      sauces: [
        {
          choice: 'traditional red',
          done: false
        },
        {
          choice: 'white garlic', 
          done: false
        },
        {
          choice: 'basil pesto', 
          done: false
        },
        {
          choice: 'spicy buffalo', 
          done: false
        },
      ],
      // Up to (4) selections. Need additional $0.25 upcharge for any more than (4).
      filterStandardToppings: '',
      standardToppings: [
        {
          choice: 'Red onion',
          done: false
        },
        {
          choice: 'broccoli', 
          done: false
        },
        {
          choice: 'jalapeño',
          done: false
        },
        {
          choice: 'sweet pepper',
          done: false
        },
        {
          choice: 'mushroom', 
          done: false
        },
        {
          choice: 'black olive',
          done: false
        },
        {
          choice: 'spinach',
          done: false
        },
        {
          choice: 'ham', 
          done: false
        },
        {
          choice: 'pepperoni',
          done: false
        },
      ],
      
      // Up to (2) selections. Need additional $0.50 upcharge for any more than (2).
      filterPremiumToppings: '',
      premiumToppings: [
        {
          choice: 'grilled chicken',
          done: false
        },
        {
          choice: 'fennel sausage', 
          done: false
        },
        {
          choice: 'crispy pancetta',
          done: false
        },
        {
          choice: 'spicy meatball',
          done: false
        },
        {
          choice: 'marinated tofu', 
          done: false
        },
        {
          choice: 'sautéed spinach',
          done: false
        },
        {
          choice: 'broccoli rabe',
          done: false
        },
        {
          choice: 'fried chickpea', 
          done: false
        },
        {
          choice: 'grilled pineapple',
          done: false
        },
      ]
    }
  },
  methods: {

    createOrder() {
      console.log("In createOrder")
      // this.pizza.ingredients.push(this.ingredient)
      // this.selected.forEach(this.pizza.ingredients.push(?))
      for (let i = 0; i < this.selected.length; i++) {
        this.pizza.ingredients.push(this.selected[i]);
        console.log("ingredient added")
      }
      this.order.pizzas.push(this.pizza)
      PizzaService.createOrder(this.order).then(() =>{
        //TO DO - check response - look for 201
        console.log("Order created.")
        this.order.pizzas=[]
      })

    },

    retrieveAvailableIngredients() {
      PizzaService.getAvailableIngredients().then((response) => {
        this.$store.commit("SET_AVAILABLE_INGREDIENTS", response.data)
      })
    }, 

    // POTENTIAL PICKUP DELIVERY METHODS
    // =================================
    // showForm() {
    //   alert(this.showAddDeliveryInfo)
    //   this.showAddDeliveryInfo = true
    //    alert(this.showAddDeliveryInfo)
    // },
    // addDeliveryInfo() {
    //   this.$store.commit('ADD_DELIVERY_INFO', this.newDeliveryInfo)
    //   this.resetForm();
    // },
    // resetForm() {
    //   this.showAddDeliveryInfo = false;
    //   this.newDeliveryInfo = {};
    // },


   
  },


  computed: {
      filteredSizes() {
      return this.sizes.filter((size) => {
        return size.choice.includes(this.filterSizes);
      });
    },
    filteredDoughs() {
      return this.doughs.filter((dough) => {
        return dough.choice.includes(this.filterDoughs);
      });
    },
    filteredStyles() {
      return this.styles.filter((style) => {
        return style.choice.includes(this.filterStyles);
      });
    },
    filteredSauces() {
      return this.sauces.filter((sauce) => {
        return sauce.choice.includes(this.filterSauces);
      });
    },
    filteredStandardToppings() {
      return this.standardToppings.filter((standardTopping) => {
        return standardTopping.choice.includes(this.filterStandardToppings);
      });
    },
    filteredPremiumToppings() {
      return this.premiumToppings.filter((premiumTopping) => {
        return premiumTopping.choice.includes(this.filterPremiumToppings);
      });
    }
  },

  created() {
    this.retrieveAvailableIngredients();
  }
 }

  




    
 
  
      
  


</script>

<style>
#CreateYourOwn {
    display: block;
    font-size: 2em;
    margin-block-start: 0.67em;
    margin-block-end: 0.67em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    font-weight: bold;
    text-align: center;
}

.BTTNS {
    position: absolute;
    top: 15%;
    left: 35%;
    font-size: 16px;
    padding: 12px 24px;
    border-radius: 5px;
    transform: translate(-50%, -50%);
    -ms-transform: translate(-50%, -50%);

}
.PickupDelivery {
    font-size: 16px;
    margin: 20px;
    width: 120px;
    height: 60px;
    background-color: #F76C4B;
    border-radius: 60px;
    border: solid white 2px;
    color: white;
    cursor: pointer;
}
.form-element {
  border-radius: 25px;
}

</style>