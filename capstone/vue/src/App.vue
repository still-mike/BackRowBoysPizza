<template>
  <div id="app">
    <website-header v-if="isLoginPage === false"/>
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

export default {
  data() {
    return {
      state: {
        isLoginPage: false // Tells us if we are on the login page
      }
    }
  },
  components: {
    WebsiteHeader,
    WebsiteFooter
  },
  watch: { // Watch section will actively watch part of the app
    $route: { // Watch the router which has the URL
      immediate: true, // Always watch
        handler(to) { // Function to change state
          if (to.path === "/login") { // If the URL path is the login page 
            this.isLoginPage = true; // Change state to true
          } else {
            this.isLoginPage = false; // Otherwise change state to false
          }
        }
    }
  },
  name: "app"
}
</script>

<style>
body {
    background-color: #B7D8BD;
    font-family:'Major Mono Display', monospace;
    
}
.logoFont {
    font-family: 'Slackey',cursive;

}
#app {
  font-family:'Major Mono Display', monospace;
  display:flex;
  min-height: 100vh;
  flex-direction: column;
}
</style>
