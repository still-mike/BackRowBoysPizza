<template>
<div>

  <form v-on:submit.prevent>

    <!-- PICKUP or DELIVERY -->

    <!-- <div class='BTTNS'>
        <button tag="button" class="PickupDelivery">Pickup</button>
        <button tag="button" class="PickupDelivery">Delivery</button>
      </div>



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
        <label for="email">phone number:</label>
        <input id="email" type="text" v-model="newDeliveryInfo.phoneNumber" />
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
     </div> -->
    




    
    <h1>specialty pies</h1>
    <p>12" small ($14.99) | 16" medium ($16.99) | 20" ($19.99)</p>

    

    <div class="pizza-size-list">
      <h2>choose a size</h2>
      <!-- drop down -->
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
  
    <div class="fettig">
      <h2>the fettig</h2>
      <p>balsamic drizzle, housemade mozzarella, sundried tomato, walnuts, basil</p>
    </div>
    <div class="finkeldey">
      <h2>the finkeldey</h2>
      <p>smoked bbq sauce, housemade mozzarella, fontina, roasted chicken, red onion, banana pepper</p>
    </div>
    <div class="nowell">
      <h2>the nowell</h2>
      <p>parmigiano, ricotta fonduta, baby spinach, onion, roasted garlic, chili flake</p>
    </div>
    <div class="still">
      <h2>the still</h2>
      <p>white pie, sriacha honey, cheese blend, brussels, bacon, shaved red onion</p>
  
    </div>
</form>
</div>
</template>

<script>

// import PizzaService from "@/services/PizzaService.js"

export default {
  name: 'order-now-specialty-pizza',
  data () {
    return {
    }
  },

  methods: {

   
  }

}
</script>

<style>
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