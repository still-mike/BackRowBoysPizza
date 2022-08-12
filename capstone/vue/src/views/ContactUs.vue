<template>
  <div class="contact">
  <h1 class="contactHeader">contact us</h1>
  <div class="firstRow">
  <contact-details class="contactInfo" :typeOfAddress="'phone'" :title="'call us'" :address="'(484)-803-8318'"/>
  <contact-details class="contactInfo" :typeOfAddress="'email'" :title="'email us'" :address="'backrowboyzpizza@gmail.com'"/>
  </div>
  <div class="secondRow">
  <contact-details :title="'leave us a review!'" :typeOfAddress="'review'"  :address="'yelp.com/backrowboyzpizza'"/>
  </div>
  </div>
</template>

<script>
import ContactDetails from "../components/ContactDetails.vue"
export default {
  components: {
    ContactDetails
  }


}
</script>

<style>
.firstRow {
  display: flex;
  text-align: center;
  justify-content: center;
}
.firstRow div {
  margin: 1em;
  background-color: #FAF9F6;
  text-align: center;
}

.contactInfo {
  width: 30%;
}

.secondRow {
  display: flex;
  text-align: center;
  justify-content: center;
}
.secondRow div {
  background-color: #FAF9F6;
  width: 69%;
  text-align: center;
  margin: auto;
  padding-bottom: 0.5em;
}
.contactHeader {
  text-align: center;
  margin-top: 2em;
}
.contact a {
  text-decoration: none;
  color: #F76C4B;
}
.contact a:visited {
  color: #F76C4B;
}
</style>
