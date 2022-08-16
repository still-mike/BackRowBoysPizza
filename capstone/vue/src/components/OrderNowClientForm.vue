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
      <option>Small</option>
      <option>Medium</option>
      <option>Large</option>
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
      <option>Gluten-free +$3.50</option>
      <option>Cauliflower, <em>vegan</em> +$3.50</option>
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
      <option>Deepdish +$2.50</option>
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
      <option>Spicy Buffalo</option>
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
        <p>first 4 are free. additional toppings ($0.25) each</p>
        <ul>
          <li v-for="standardIngredient in standardIngredients" v-bind:key="standardIngredient.ingredientName">            
            <input type="checkbox" v-model="selectedStandardIngredients"  :value="standardIngredient"/>
          {{ standardIngredient.ingredientName }}
          </li>
        </ul>      
    </div>

    <div class="premium-topping-list">    
        <h2>choose premium toppings</h2>
        <p>first 2 are free. additional toppings ($0.50) each</p>
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

  <div class="running-total">
  <p>Current total: {{ pizzaPriceTotal }}</p>
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
        pizzaSize: 'Medium',
        dough: 'Hand-tossed traditional',
        shape: 'Classic pie',
        sauceType: 'Traditional red',
        description: "This is a test",
        pizzaPrice: 14.99,
        isSpecialty: false,
        orderId: 0,
        ingredients: [],
        isAvailable: true,
        status: "Pending"
        

      },

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
          choice: 'Small',
          done: false
        },
        {
          choice: 'Medium',
          done: false
        },
        {
          choice: 'Large',
          done: false
        }
      ],

    filterDoughs: '',
    doughs: [
        {
          choice: 'Hand-tossed traditional',
          done: false
        },
        {
          choice: 'Gluten-free (+$3.50)', // plus $3.50 upcharge
          done: false
        },
        {
          choice: 'Cauliflower, vegan (+$3.50)', // plus $3.50 upcharge
          done: false
        },
      ],

      filterStyles: '',
      styles: [
        {
          choice: 'Classic pie',
          done: false
        },
        {
          choice: 'Flatbread', 
          done: false
        },
        {
          choice: 'Deepdish (+$2.50)', // plus $2.50 upcharge
          done: false
        },
      ],

      filterSauces: '',
      sauces: [
        {
          choice: 'Traditional red',
          done: false
        },
        {
          choice: 'White garlic', 
          done: false
        },
        {
          choice: 'Basil pesto', 
          done: false
        },
        {
          choice: 'Spicy Buffalo', 
          done: false
        },
      ],


    }
  },
  methods: {

    createOrder() {
      console.log("In createOrder")
      
      for (let i = 0; i < this.selectedStandardIngredients.length; i++) {
        this.pizza.ingredients.push(this.selectedStandardIngredients[i]);
        console.log("ingredient added")
      }
      for (let j = 0; j < this.selectedPremiumIngredients.length; j++) {
        this.pizza.ingredients.push(this.selectedPremiumIngredients[j]);
        console.log("ingredient added")
      }
      this.pizza.pizzaPrice = this.pizzaPriceTotal
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
      
      if (this.pizza.pizzaSize == 'Medium') {
        pizzaPrice += 3
      }
      else if (this.pizza.pizzaSize == 'Large') {
        pizzaPrice += 6
      }
      if (this.pizza.dough == 'Cauliflower, vegan +$3.50' || this.pizza.dough == 'Gluten-free +$3.50'){
        pizzaPrice += 3.50
      }
      if (this.pizza.shape == 'Deepdish +$2.50') {
        pizzaPrice += 2.50
      }

      for (let i = 4; i < this.selectedStandardIngredients.length; i++) {
        pizzaPrice += 0.25
      }
      for (let j = 2; j < this.selectedPremiumIngredients.length; j++) {
        pizzaPrice += 0.50
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