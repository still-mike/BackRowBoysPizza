
<template>
  <div>
    <h1>Order Now</h1>
  <div id="pizza-size-app">
    <order-now-client-form></order-now-client-form>
    <!-- <pizza-size-list></pizza-size-list> -->
    </div>
</div>
</template>

<script>
import OrderNowClientForm from '../components/OrderNowClientForm.vue';


export default {
  name: 'order-now',
  data() {
    return {
      filterText: '',
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
        },
      ]
    }
  },
  components: {
    OrderNowClientForm
    
    
    
  },

 computed: {
    filteredSizes() {
      return this.sizes.filter((size) => {
        return size.choice.includes(this.filterText);
      });
    }
 }
}
</script>

<style></style> 