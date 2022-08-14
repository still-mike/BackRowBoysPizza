<template>
  
  <div id="capsule">
       <website-header id="Header"/>
       <h1 class="Location">location</h1> 
   <div class="landing">
    <div id ='MainBody'>
    </div>
  </div>
  <website-footer/>
  </div>
</template>

<script>
import WebsiteHeader from "@/components/WebsiteHeader.vue" 
import WebsiteFooter from "@/components/WebsiteFooter.vue"
export default {

components: {
    WebsiteHeader,
    WebsiteFooter
}

}
</script>

<style>
.Location {
  text-align: center;
}
.landing {
    width: 100%;
    height: 800px;
    overflow: hidden;
    background-image: URL("https://images.unsplash.com/photo-1624821588855-a3ffb0b050ff?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80");
}
</style>