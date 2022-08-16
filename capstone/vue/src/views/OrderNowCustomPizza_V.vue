<template>
  <div id="capsule">
    <website-header id="Header"/>
    <div>
    <h1>create-your-own</h1>

<!-- Import OrderNowCustomPizza component
Provide router link to toggle between OrderNowSpecialtyPizza_V vue -->

    </div>
    <website-footer id ="footer"/>
</div>
</template>

<script>
// Import OrderNowCustomPizza component 
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
    // OrderNowCustomPizza

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