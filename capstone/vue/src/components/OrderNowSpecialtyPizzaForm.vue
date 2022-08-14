<template>
<div>
    
    <h1>specialty pies</h1>
    <div class="fettig">
      <h2>the fettig</h2>
      <p>balsamic drizzle, housemade mozzarella, sundried tomato, walnuts, basil</p>
      <ul>
        <li v-for="size in filteredSizes" v-bind:key="size.choice"
            v-bind:class="{ finished: size.selected }">
          <input type="checkbox" v-model="size.selected" />
          {{ size.choice }}
        </li>
      </ul>
    </div>
    <div class="finkeldey">
      <h2>the finkeldey</h2>
      <p>smoked bbq sauce, housemade mozzarella, fontina, roasted chicken, red onion, banana pepper</p>
      <ul>
        <li v-for="dough in filteredDoughs" v-bind:key="dough.choice"
            v-bind:class="{ finished: dough.done }">
          <input type="checkbox" v-model="dough.done" />
          {{ dough.choice }}
        </li>
      </ul>
    </div>
    <div class="nowell">
      <h2>the nowell</h2>
      <p>parmigiano, ricotta fonduta, baby spinach, onion, roasted garlic, chili flake</p>
      <ul>
        <li v-for="style in filteredStyles" v-bind:key="style.choice"
            v-bind:class="{ finished: style.done }">
          <input type="checkbox" v-model="style.done" />
          {{ style.choice }}
        </li>
      </ul>
    </div>
    <div class="still">
      <h2>the still</h2>
      <p>white pie, sriacha honey, cheese blend, brussels, bacon, shaved red onion</p>
      <ul>
        <li v-for="sauce in filteredSauces" v-bind:key="sauce.choice"
            v-bind:class="{ finished: sauce.done }">
          <input type="checkbox" v-model="sauce.done" />
          {{ sauce.choice }}
        </li>
      </ul>
    </div>
    </div>
  
</template>

<script>
export default {

}
</script>

<style>

</style>