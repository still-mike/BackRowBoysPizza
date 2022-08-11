<template>
  <div class="home">
    <div id ='Main Body'>
        <img id ="MainPizza" src="https://images.unsplash.com/photo-1624821588855-a3ffb0b050ff?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80">
        <div  class='BTN'>
            <router-link :to="{name: 'orderNow'}" tag="button" class="MidPageLinks">Order Now</router-link>
            <router-link :to="{name: 'location'}" tag="button" class="MidPageLinks">Location</router-link>
        </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>


<!--<template>
  <div class="home">
    <h1>Home</h1>
    <h2>Welcome to Back Row Boyz Pizza</h2>
    <p>We will be with you shortly!</p>
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>-->
