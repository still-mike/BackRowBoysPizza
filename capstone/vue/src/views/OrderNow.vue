
<template>
  <div id="capsule">
    <website-header id="Header"/>
    <div>
    <h1>order now</h1>
    
    <order-now-client-form></order-now-client-form>
    <!-- <order-now-custom-pizza></order-now-custom-pizza> -->
    <!-- <order-now-specialty-pizza></order-now-specialty-pizza> -->

    <!-- Provide router link to images to toggle between OrderNowCustomPizza_V vue and OrderNowSpecialtyPizza_V vue -->
    
    </div>
    <website-footer id ="footer"/>
</div>
</template>

<script>

import OrderNowClientForm from '../components/OrderNowClientForm.vue';
import WebsiteHeader from "@/components/WebsiteHeader.vue" 
import WebsiteFooter from "@/components/WebsiteFooter.vue"
// import OrderNowCustomPizza from '../components/OrderNowCustomPizza.vue';
// import OrderNowSpecialtyPizza from '../components/OrderNowSpecialtyPizza.vue';

export default {
  data() {
    return {
     
    }
  },
  components: {
    OrderNowClientForm,
    WebsiteHeader,
    WebsiteFooter,
    // OrderNowCustomPizza
    // OrderNowSpecialtyPizza
    
    
    
    
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