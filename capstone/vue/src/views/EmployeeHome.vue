<template>
  <div>
    <h1>Employee Home</h1>
    <boards-list class='boardsList'/>
  </div>
</template>

<script>
import BoardsList from '@/components/BoardsList';

export default {
  components: {
    BoardsList
  },
  
  created() {
    // if there are boards, forward to first board/pizza list
    if (this.$store.state.boards.length > 0) {
      const firstBoard = this.$store.state.boards[0];
      this.$router.push({ name: 'Board', params: { id : firstBoard.id }})
    }
  }
};
</script>

<style scoped>

.boardsList{
  grid-area: boards;
}

</style>