<template>
  <div>
    <div>
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
        v-if="!isLoading && !addToDelivery"
        v-on:click="addToDelivery"

        >
      Delivery
    </button>

    <form v-on:submit.prevent="addDeliveryInfo" v-if="showForm === true">
      <div class="form-element">
        <label for="name">Name:</label>
        <input id="name" type="text" v-model="newDeliveryInfo.name" />
      </div>
      <div class="form-element">
        <label for="email">Email:</label>
        <input id="email" type="text" v-model="newDeliveryInfo.email" />
      </div>
      <div class="form-element">
        <label for="address">Address:</label>
        <input id="address" type="text" v-model="newDeliveryInfo.address" />
      </div>
      <div class="form-element">
        <label for="cardNumber">Credit card number:</label>
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
      showAddDeliveryInfo: false,
      newDeliveryInfo: {
    
      },
    };
  },
  methods: {
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

</style>