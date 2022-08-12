
<template>
  <div>
    <div>
    <h1>order now</h1>
    <order-now-add-delivery></order-now-add-delivery>
    <order-now-client-form></order-now-client-form>
    
    </div>
</div>
</template>

<script>
import OrderNowAddDelivery from '../components/OrderNowAddDelivery.vue';
import OrderNowClientForm from '../components/OrderNowClientForm.vue';


export default {
  data() {
    return {
     
    }
  },
  components: {
    OrderNowAddDelivery,
    OrderNowClientForm
    
    
    
    
  },

 computed: {
   
 }
}
</script>

<style></style> 