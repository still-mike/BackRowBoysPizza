<template>
<div>

   <div id="pizza-size-app">
    <!-- <pizza-size-list></pizza-size-list> -->
  </div>
    <div class="pizza-size-list">
      <h1>Choose a size</h1>
      <ul>
        <li v-for="size in filteredSizes" v-bind:key="size.choice"
            v-bind:class="{ finished: size.selected }">
          <input type="checkbox" v-model="size.selected" />
          {{ size.choice }}
        </li>
      </ul>
    </div>
    <div class="dough-list">
      <h1>Choose a dough</h1>
      <ul>
        <li v-for="dough in filteredDoughs" v-bind:key="dough.choice"
            v-bind:class="{ finished: dough.done }">
          <input type="checkbox" v-model="dough.done" />
          {{ dough.choice }}
        </li>
      </ul>
    </div>
    <div class="style-list">
      <h1>Choose a style</h1>
      <ul>
        <li v-for="style in filteredStyles" v-bind:key="style.choice"
            v-bind:class="{ finished: style.done }">
          <input type="checkbox" v-model="style.done" />
          {{ style.choice }}
        </li>
      </ul>
    </div>
    <div class="sauce-list">
      <h1>Choose a sauce</h1>
      <ul>
        <li v-for="sauce in filteredSauces" v-bind:key="sauce.choice"
            v-bind:class="{ finished: sauce.done }">
          <input type="checkbox" v-model="sauce.done" />
          {{ sauce.choice }}
        </li>
      </ul>
    </div>
    <div class="standard-topping-list">
      <h1>Choose standard toppings</h1>
      <ul>
        <li v-for="standardTopping in filteredStandardToppings" v-bind:key="standardTopping.choice"
            v-bind:class="{ finished: standardTopping.done }">
          <input type="checkbox" v-model="standardTopping.done" />
          {{ standardTopping.choice }}
        </li>
      </ul>
    </div>
     <div class="premium-topping-list">
      <h1>Choose premium toppings</h1>
      <ul>
        <li v-for="premiumTopping in filteredPremiumToppings" v-bind:key="premiumTopping.choice"
            v-bind:class="{ finished: premiumTopping.done }">
          <input type="checkbox" v-model="premiumTopping.done" />
          {{ premiumTopping.choice }}
        </li>
      </ul>
    </div>

</div>
</template>

<script>
export default {
     data() {
    return {
      filterSizes: '',
      sizes: [
        {
          choice: '12" Small',
          done: false
        },
        {
          choice: '16" Medium',
          done: false
        },
        {
          choice: '20" Large',
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
          choice: 'Gluten-free', // plus $3.50 upcharge
          done: false
        },
        {
          choice: 'Cauliflower, vegan', // plus $3.50 upcharge, italicize vegan
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
          choice: 'Deepdish', // plus $2.50 upcharge
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
          choice: 'Spicy buffalo', 
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
          choice: 'Broccoli', 
          done: false
        },
        {
          choice: 'Jalapeño',
          done: false
        },
        {
          choice: 'Sweet pepper',
          done: false
        },
        {
          choice: 'Mushroom', 
          done: false
        },
        {
          choice: 'Black olive',
          done: false
        },
        {
          choice: 'Spinach',
          done: false
        },
        {
          choice: 'Ham', 
          done: false
        },
        {
          choice: 'Pepperoni',
          done: false
        },
      ],
      // Up to (2) selections. Need additional $0.50 upcharge for any more than (2).
      filterPremiumToppings: '',
      premiumToppings: [
        {
          choice: 'Grilled chicken',
          done: false
        },
        {
          choice: 'Fennel sausage', 
          done: false
        },
        {
          choice: 'Crispy pancetta',
          done: false
        },
        {
          choice: 'Spicy meatball',
          done: false
        },
        {
          choice: 'Marinated tofu', 
          done: false
        },
        {
          choice: 'Sautéed spinach',
          done: false
        },
        {
          choice: 'Broccoli rabe',
          done: false
        },
        {
          choice: 'Fried chickpea', 
          done: false
        },
        {
          choice: 'Grilled pineapple',
          done: false
        },
      ]
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