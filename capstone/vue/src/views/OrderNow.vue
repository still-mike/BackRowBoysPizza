
<template>
  <div id="capsule">
    <website-header id="Header"/>
    <div>
    <h1>order now</h1>

    <div class = 'RouterPhoto'>
      <router-link :to="{name: 'orderNowCustomPizzaV'}"><img src="../assets/cyo_no_border.png" class="MidPageLinks"> </router-link>
      <router-link :to="{name: 'orderNowSpecialtyPizzaV'}"><img src="../assets/sp_no_border.png" class="MidPageLinks"></router-link>
    </div>
    
    
    

    <!-- <div  class='BTN'>

            <router-link :to="{name: 'orderNowCustomPizzaV'}" tag="button" img src="../assets/cyo_no_border" class="MidPageLinks">Create Your Own</router-link>
            <router-link :to="{name: 'orderNowSpecialtyPizzaV'}" tag="button" class="MidPageLinks">Specialty Pies</router-link>
        </div> -->

    <!-- Provide router link to images to toggle between OrderNowCustomPizza_V vue and OrderNowSpecialtyPizza_V vue -->
    
    </div>
    <website-footer id ="footer"/>
</div>
</template>

<script>


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

.BTN {
    position: absolute;
    top: 51%;
    left: 50%;
    font-size: 16px;
    padding: 12px 24px;
    border-radius: 5px;
    transform: translate(-50%, -50%);
    -ms-transform: translate(-50%, -50%);

}

.MidPageLinks {
    font-size: 16px;
    margin: 20px;
    width: 400px;
    height: 200px;
    background-color: #F76C4B;
    border-radius: 60px;
    border: solid rgb(5, 0, 0) 2px;
    color: white;
    cursor: pointer;
}

.RouterPhoto {
   position: absolute;
    top: 51%;
    left: 50%;
    font-size: 16px;
    padding: 12px 24px;
    border-radius: 5px;
    transform: translate(-50%, -50%);
    -ms-transform: translate(-50%, -50%);
}

</style> 