<template>
  <div>
    <div>
      <div class='BTTNS'>
        <button tag="button" class="PickupDelivery">Pickup</button>
        <button tag="button" class="PickupDelivery">Delivery</button>
      </div>
      <!-- <button
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
    </button> -->

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
        <textarea id="cardNumber" v-model="newDeliveryInfo.cardNumber"></textarea>
      </div>
      <input type="submit" value="Save" />
      <input type="button" value="Cancel" v-on:click.prevent="resetForm" />
    </form>
  </div>
    
  </div>
</template>

<script>
export default {
  name: "add-delivery-info",
  data() {
    return {
      showAddDeliveryInfo: true,
      newDeliveryInfo: {
    
      },
    };
  },
  methods: {
    showForm() {
      alert(this.showAddDeliveryInfo)
      this.showAddDeliveryInfo = true
       alert(this.showAddDeliveryInfo)

    },
    addDeliveryInfo() {
      this.$store.commit('ADD_DELIVERY_INFO', this.newDeliveryInfo)
      this.resetForm();
    },
    resetForm() {
      this.showAddDeliveryInfo = false;
      this.newDeliveryInfo = {};
    },
  },


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
    
    

</style>