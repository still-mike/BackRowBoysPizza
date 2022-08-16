<template>
  <div id="capsule">
    <website-header id="Header"/>
    <div>
    <h1>specialty pies</h1>

<!-- Import OrderNowSpecialtyPizza component
Provide router link to toggle between OrderNowCustomPizza_V vue -->

    </div>
    <website-footer id ="footer"/>
</div>
</template>

<script>
// Import OrderNowSpecialtyPizza component 
import WebsiteHeader from "@/components/WebsiteHeader.vue" 
import WebsiteFooter from "@/components/WebsiteFooter.vue"

export default {
  data() {
    return {
     
    }
  },
  components: {

    WebsiteHeader,
    WebsiteFooter,
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