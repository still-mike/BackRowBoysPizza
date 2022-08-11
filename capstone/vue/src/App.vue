<template>
  <div id="app">
    <website-header/>
    <!--<div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div> FROM STARTER CODE. I DON'T THINK IT'S IMPORTANT--> 
    <router-view /> 
    <website-footer/>
  </div>
</template>
<script>
import WebsiteHeader from "./components/WebsiteHeader.vue" 
import WebsiteFooter from "./components/WebsiteFooter.vue"
import "../public/style.css"
export default {
  components: {
    WebsiteHeader,
    WebsiteFooter
  },
  name: "app"
}
</script>
