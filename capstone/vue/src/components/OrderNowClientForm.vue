<template>
<div>
   <div>
     
  </div>
  <h1>create-your-own</h1>
  
    <div class="pizza-size-list">
      <h2>choose a size</h2>
      <!-- drop down -->
      <div>{{ selected }}</div>
    <select v-model="selected" >
      <option disabled value="">please select one</option>
      <option>12" Small</option>
      <option>16" Medium</option>
      <option>20" Large</option>
      </select>
      <!-- check boxes -->
      <ul>
        <li v-for="size in filteredSizes" v-bind:key="size.choice"
            v-bind:class="{ finished: size.selected }">
          <input type="radio" v-model="size.selected" />
          {{ size.choice }}
        </li>
      </ul>
    </div>
    
    <div class="dough-list">
      <h2>choose a dough</h2>
      <!-- drop down -->
      <div>{{ selected }}</div>
    <select v-model="selected" >
      <option disabled value="">Please select one</option>
      <option>DOUGH</option>
      <option>DOUGH</option>
      <option>DOUGH</option>
      </select>
      <!-- check boxes -->
      <ul>
        <li v-for="dough in filteredDoughs" v-bind:key="dough.choice"
            v-bind:class="{ finished: dough.done }">
          <input type="checkbox" v-model="dough.done" />
          {{ dough.choice }}
        </li>
      </ul>
    </div>

    <div class="style-list">
      <h2>choose a style</h2>
      <!-- drop down -->
      <div>{{ selected }}</div>
    <select v-model="selected" >
      <option disabled value="">Please select one</option>
      <option>STYLE</option>
      <option>STYLE</option>
      <option>STYLE</option>
      </select>
      <!-- check boxes -->
      <ul>
        <li v-for="style in filteredStyles" v-bind:key="style.choice"
            v-bind:class="{ finished: style.done }">
          <input type="checkbox" v-model="style.done" />
          {{ style.choice }}
        </li>
      </ul>
    </div>

    <div class="sauce-list">
      <h2>choose a sauce</h2>
      <!-- drop down -->
      <div>{{ selected }}</div>
    <select v-model="selected" >
      <option disabled value="">Please select one</option>
      <option>SAUCE</option>
      <option>SAUCE</option>
      <option>SAUCE</option>
      </select>
      <!-- check boxes -->
      <ul>
        <li v-for="sauce in filteredSauces" v-bind:key="sauce.choice"
            v-bind:class="{ finished: sauce.done }">
          <input type="checkbox" v-model="sauce.done" />
          {{ sauce.choice }}
        </li>
      </ul>
    </div>

    <div class="standard-topping-list">


      <h2>choose standard toppings</h2>
      <ul>
        <li v-for="standardTopping in filteredStandardToppings" v-bind:key="standardTopping.choice"
            v-bind:class="{ finished: standardTopping.done }">
          <input type="checkbox" v-model="standardTopping.done" />
          {{ standardTopping.choice }}
        </li>
      </ul>
    </div>
     <div class="premium-topping-list">

       
      <h2>choose premium toppings</h2>
      <ul>
        <li v-for="premiumTopping in filteredPremiumToppings" v-bind:key="premiumTopping.choice"
            v-bind:class="{ finished: premiumTopping.done }">
          <input type="checkbox" v-model="premiumTopping.done" />
          {{ premiumTopping.choice }}
        </li>
      </ul>
    </div>
  <div>
    <button>Submit</button>
  </div>
</div>
</template>

<script>
// vanilla JS from Josh to select from an array
// Array.from(document.querySelectorAll("input[type=checkbox][name=type]:checked"), e => e.value); 
export default {
     data() {
    return {
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
          choice: 'gluten-free', // plus $3.50 upcharge
          done: false
        },
        {
          choice: 'cauliflower, vegan', // plus $3.50 upcharge, italicize vegan
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
          choice: 'deepdish', // plus $2.50 upcharge
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
          choice: 'red onion',
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