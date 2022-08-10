<template>
  <div class="pizza-size-list">
  <input type="text" v-model="filterText" />
      <h1>Choose a size</h1>
      <ul>
        <li v-for="size in filteredSizes" v-bind:key="size.choice"
            v-bind:class="{ finished: size.selected }">
          <input type="checkbox" v-model="size.selected" />
          {{ size.choice }}
        </li>
      </ul>
    </div>
</template>

<script>
export default {
  data() {
    return {
      filterText: '',
      sizes: [
        {
          size: '12" Small ($11.99)',
          selected: false
        },
        {
          size: '16" Medium ($14.99)',
          selected: false
        },
        {
          size: '20" Large ($17.99)',
          selected: false
        }
    
      ]
    }
  },
  computed: {
    filteredSizes() {
      return this.sizes.filter((size) => {
        return size.name.includes(this.filterText);
      });
    }
  }
}
</script>

<style>
.todo-list {
    width:450px;
    background: #fff;
    margin: 50px auto;
    font-family: 'Roboto Condensed', sans-serif;
    border-radius: 10px;
}
h1 {
    background:#f2f2f2;
    color:#4b86A6;
    padding:10px;
    font-size:24px;
    text-transform: uppercase;
    text-align: center;
    margin-bottom: 0px;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
}
ul {
    list-style-type: none;
    margin:0px;
    padding:0px;
}
li {
    font-size: 24px;
    border-bottom:1px solid #f2f2f2;
    padding:10px 20px;
}
li:last-child{
    border:0px;
}
.finished {
  background-color: grey;
}
input[type=text] {
  width: 75%;
  margin: auto;
  font-size: 2em;
  display:block;

}
</style>
  
