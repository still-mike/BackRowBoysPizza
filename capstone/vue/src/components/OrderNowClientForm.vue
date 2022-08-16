<template>
<div>

     <form v-on:submit.prevent>
     
  <h1>create-your-own</h1>
  12" small ($11.99) | 16" medium ($14.99) | 20" ($17.99)
  
    <div class="pizza-size-list">
      <h2>choose a size</h2>
      <!-- drop down -->
      <!-- <div>{{ size.selected }}</div> -->
    <select v-model="pizza.pizzaSize" >
      <option disabled value="">please select one</option>
      <option>12" Small</option>
      <option>16" Medium</option>
      <option>20" Large</option>
      </select>
      <!-- check boxes -->
      <!-- <ul>
        <li v-for="size in filteredSizes" v-bind:key="size.choice"
            v-bind:class="{ finished: pizza.pizzaSize }">
          <input type="radio" v-model="pizza.pizzaSize" />
          {{ size.choice }}
        </li>
      </ul> -->
    </div>
    
    <div class="dough-list">
      <h2>choose a dough</h2>
      <!-- drop down -->
      <!-- <div>{{ selected }}</div> -->
    <select v-model="pizza.dough" >
      <option disabled value="">Please select one</option>
      <option>Hand-tossed traditional</option>
      <option>Gluten-free (+$3.50)</option>
      <option>Cauliflower, <em>vegan</em> (+$3.50)</option>
      </select>
      <!-- check boxes -->
      <!-- <ul>
        <li v-for="dough in filteredDoughs" v-bind:key="dough.choice"
            v-bind:class="{ finished: dough.done }">
          <input type="checkbox" v-model="dough.done" />
          {{ dough.choice }}
        </li>
      </ul> -->
    </div>

    <div class="style-list">
      <h2>choose a style</h2>
      <!-- drop down -->
      <!-- <div>{{ selected }}</div> -->
    <select v-model="pizza.shape" >
      <option disabled value="">Please select one</option>
      <option>Classic pie</option>
      <option>Flatbread</option>
      <option>Deepdish (+$2.50)</option>
      </select>
      <!-- check boxes -->
      <!-- <ul>
        <li v-for="style in filteredStyles" v-bind:key="style.choice"
            v-bind:class="{ finished: style.done }">
          <input type="checkbox" v-model="style.done" />
          {{ style.choice }}
        </li>
      </ul> -->
    </div>

    <div class="sauce-list">
      <h2>choose a sauce</h2>
      <!-- drop down -->
      <!-- <div>{{ selected }}</div> -->
    <select v-model="pizza.sauceType" >
      <option disabled value="">Please select one</option>
      <option>Traditional red</option>
      <option>White garlic</option>
      <option>Basil pesto</option>
      <option>Spicy buffalo</option>
      </select>
      <!-- check boxes -->
      <!-- <ul>
        <li v-for="sauce in filteredSauces" v-bind:key="sauce.choice"
            v-bind:class="{ finished: sauce.done }">
          <input type="checkbox" v-model="sauce.done" />
          {{ sauce.choice }}
        </li>
      </ul> -->
    </div>

    <div class="standard-topping-list">
        <h2>choose standard toppings</h2>
        <p>select additional toppings ($0.25) each</p>
        <ul>
          <li v-for="standardIngredient in standardIngredients" v-bind:key="standardIngredient.ingredientName">            
            <input type="checkbox" v-model="selectedStandardIngredients"  :value="standardIngredient"/>
          {{ standardIngredient.ingredientName }}
          </li>
        </ul>      
    </div>

    <div class="premium-topping-list">    
        <h2>choose premium toppings</h2>
        <p>select additional toppings ($0.50) each</p>
        <ul>
          <li v-for="premiumIngredient in premiumIngredients" v-bind:key="premiumIngredient.ingredientName">            
            <input type="checkbox" v-model="selectedPremiumIngredients"  :value="premiumIngredient"/>
          {{ premiumIngredient.ingredientName }}
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
     data() {
    return {


      selectedStandardIngredients: [],
      selectedPremiumIngredients: [],
      
      
      
      ingredient: {
        "id": 1,
        "ingredientName": "Red onion",
        "tier": "Standard",
        "ingredientPrice": 0.25,
        "available": true
      },

      
      pizza: {
        pizzaSize: '16" medium',
        dough: 'hand-tossed traditional',
        shape: 'classic pie',
        sauceType: 'traditional red',
        description: "This is a test",
        pizzaPrice: 14.99,
        isSpecialty: false,
        orderId: 0,
        ingredients: [],
        isAvailable: true,
        status: "Pending"
        

      },
     
     
     // pizza: {
      //   "pizzaSize": "Large",
      //   "dough": "Traditonal",
      //   "shape": "round",
      //   "sauceType": "red",
      //   "description": "This is a test",
      //   "pizzaPrice": 15,
      //   "isSpecialty": false,
      //   "orderId": 0,
      //   "ingredients": [],
      //   "isAvailable": true,
      //   "status": "Pending"
        

      // },

      order: {
        orderStatus: "Pending",
        isDelivery: false,
        custEmail: "test@email.com",
        pizzas: []
      },
    //       private Long id;
    // private String pizzaSize;
    // private String dough;
    // private String shape;
    // private String sauceType;
    // private String description;
    // private BigDecimal pizzaPrice;
    // private boolean isSpecialty;
    // private Long orderId;
    // private List<Ingredient> ingredients = new ArrayList<>();
    // private boolean isAvailable;
    // private Long boardId;
    // private String status;
// =================
// ORDER
// =================
  // private Long id;
  //   private String orderStatus;
  //   private boolean isDelivery;
  //   private String employeeName;
  //   private LocalDateTime orderTime;
  //   private String custAddress;
  //   private String custEmail;
  //   private List<Pizza> pizzas = new ArrayList<>();

    // =======================

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


    }
  },
  methods: {

    createOrder() {
      console.log("In createOrder")
      // this.pizza.ingredients.push(this.ingredient)
      // this.selected.forEach(this.pizza.ingredients.push(?))
      for (let i = 0; i < this.selectedStandardIngredients.length; i++) {
        this.pizza.ingredients.push(this.selectedStandardIngredients[i]);
        console.log("ingredient added")
      }
      for (let j = 0; j < this.selectedPremiumIngredients.length; j++) {
        this.pizza.ingredients.push(this.selectedPremiumIngredients[j]);
        console.log("ingredient added")
      }
      this.order.pizzas.push(this.pizza)
      PizzaService.createOrder(this.order).then(() =>{
        //TO DO - check response - look for 201
        console.log("Order created.")
        this.order.pizzas=[]
        this.selectedStandardIngredients = []
        this.selectedPremiumIngredients = []
      })

    },

    retrieveAvailableIngredients() {
      PizzaService.getAvailableIngredients().then((response) => {
        this.$store.commit("SET_AVAILABLE_INGREDIENTS", response.data)
      })
    }
   
  },


  computed: {

    pizzaPriceTotal() {
      let pizzaPrice = 11.99 
      
      if (this.pizza.pizzaSize == '16" medium') {
        pizzaPrice += 3
      }
      else if (this.pizza.pizzaSize == '20" large') {
        pizzaPrice += 3
      }


      return pizzaPrice
    },
    
    standardIngredients() {
      let standardIngredients = this.$store.state.availableIngredients.filter( ingredient => ingredient.tier == 'Standard' )
      // return this.$store.state.filter(())
      return standardIngredients
    },

    premiumIngredients() {
      let premiumIngredients = this.$store.state.availableIngredients.filter( ingredient => ingredient.tier == 'Premium' )
      // return this.$store.state.filter(())
      return premiumIngredients
    },


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
    
  },

  created() {
    this.retrieveAvailableIngredients();
  }
 }

  




    
 
  
      
  


</script>

<style>

</style>