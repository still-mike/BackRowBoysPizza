<template>
  <div>
      <h4>{{title}}</h4>
  <div>
       <a href="mailto:backrowboyzpizza@gmail.com" class="btn-container" v-if="typeOfAddress==='email'">{{address}}</a>
       <p v-if="typeOfAddress==='phone'">{{address}}</p>
       <a href="https://www.yelp.com/backrowboyzpizza" v-if="typeOfAddress ==='review'">{{address}}</a>
       

  </div>
  </div>
</template>

<script>
export default {
    name: "contact-details",
    props: [
        "title", "address", "typeOfAddress"
    ]

}
</script>

<style>

</style>