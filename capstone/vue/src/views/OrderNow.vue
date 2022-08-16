
<template>
  <div id="capsule">
    <website-header id="Header"/>
    <div>
    <h1>order now</h1>
    
    <!-- <order-now-add-delivery></order-now-add-delivery> -->
    <order-now-client-form></order-now-client-form>
    <!-- <order-now-specialty-pizza-form></order-now-specialty-pizza-form> -->
    
    </div>
    <website-footer id ="footer"/>
</div>
</template>

<script>
// import OrderNowAddDelivery from '../components/OrderNowAddDelivery.vue';
import OrderNowClientForm from '../components/OrderNowClientForm.vue';
import WebsiteHeader from "@/components/WebsiteHeader.vue" 
import WebsiteFooter from "@/components/WebsiteFooter.vue"
// import OrderNowSpecialtyPizzaForm from '../components/OrderNowSpecialtyPizzaForm.vue';

export default {
  data() {
    return {
     
    }
  },
  components: {
    // OrderNowAddDelivery,
    OrderNowClientForm,
    WebsiteHeader,
    WebsiteFooter,
    // OrderNowSpecialtyPizzaForm
    
    
    
    
  },

 computed: {
   
 }
}
</script>

<style scoped>

div#capsule {
    font-family: 'Major Mono Display', monospace;
    display: flex;
    min-height: 100vh;
    flex-direction: column;
    background-color: #B7D8BD;
}

</style> 