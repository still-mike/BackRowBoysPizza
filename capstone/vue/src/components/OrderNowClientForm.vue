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
        <p>select up to (4) | additional toppings ($0.25) each<p>
        <div>
            <select v-model="selected" multiple>            
                <option v-for="standardTopping in standardToppings" 
                        :value="standardTopping.choice" v-bind:key="standardTopping.choice">
                    {{ standardTopping.choice }}
                </option>               
            </select>
        </div>
      
      
      
      <!-- <h2>choose standard toppings</h2>
      select up to (4) | additional toppings ($0.25) each
      
      <ul>
        <li v-for="standardTopping in filteredStandardToppings" v-bind:key="standardTopping.choice"
            v-bind:class="{ finished: standardTopping.done }">
          <input type="checkbox" v-model="standardTopping.done" />
          {{ standardTopping.choice }}
        </li>
      </ul> -->
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
      this.pizza.ingredients.push(this.ingredient)
      this.order.pizzas.push(this.pizza)
      PizzaService.createOrder(this.order).then(() =>{
        //TO DO - check response - look for 201
        console.log("Order created.")
        this.order.pizzas=[]
      })

    }
   
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
  }
 }

  




    
 
  
      
  


</script>

<style>

</style>