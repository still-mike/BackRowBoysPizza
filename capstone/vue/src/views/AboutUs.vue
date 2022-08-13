<template>
<div>
  <h1 class = "AboutUs">about us</h1>
  <div class="TomatoContainer">
    <div class="Hours"> 
      <h2>business hours</h2>
      <ul class="HoursList">
        <li class="Weekday">monday: 10am-11pm</li>
        <li class="Weekday">tuesday: 10am-11pm</li>
        <li class="Weekday">wednesday: 10am-11pm</li>
        <li class="Weekday">thursday: 10am-11pm</li>
        <li class="Weekday">friday: 10am-11pm</li>
        <li class="Weekday">saturday: 10am-12am</li>
        <li class="Weekday">sunday: 10am-6pm</li>
      
      </ul>
  </div>
  <div class="OurStory">
    <h2>our story</h2>
    <p id ="OriginStory">at back row boyz pizza we serve pizza and...well... that's pretty much it. you can order one of our specialty pizza's; the fettig, the finkeldey, the nowell, or the still! if you're picky that's fine! you also have the option of customizing your own pizza!

if you can't make it to us - no problem - we'll come to you! click on the order now tab above and we'll get it to you.</p>
  </div>
  </div>

</div>
</template>

<script>
export default {

}
</script>

<style>
.TomatoContainer {
  background-image: URL("https://images.unsplash.com/photo-1624821588855-a3ffb0b050ff?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80");
  height: 700px;
  padding: 20px;
}
.AboutUs {
  text-align: center;
}
.Hours {
   text-align: center;
   width: 30%;
   margin: auto;
   margin-bottom: 2em;
   margin-top: 0em;
   padding: 1em;
   background-color: #F7F3E8;
  
}
#HoursList{
  text-align: center;
  padding: 0;
}
.Weekday {
  list-style: none;
  padding: .2em;
}
.OurStory { 
  text-align: center;
  width: 60%;
  margin: auto;
  padding: 1em;
  background-color: #F7F3E8;
}
#OriginStory {
  text-align: justify;
  padding: 1em;
}
</style>