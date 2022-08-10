<template>
  <div>
    <div class="header">
      <h1>{{ title }}</h1>
      <router-link
        tag="button"
        class="btn addNewOrder"
        :to="{ name: 'AddOrder', params: { boardID: this.boardId } }"
        v-if="!isLoading"
        >Add New Order</router-link
      >
      <button
        class="btn btn-cancel clearAllOrders"
        v-if="!isLoading"
        v-on:click="clearAllOrders"
      >
        Clear All Orders
      </button>
        <!-- </div>
    <div class="loading" v-if="isLoading">
      <img src="../assets/ping_pong_loader.gif" />
    </div>
    <div v-else>
      <div class="status-message error" v-show="errorMsg !== ''">
        {{ errorMsg }}
      </div> -->
      <div class="boards">
        <board-column
          title="Pending"
          :cards="pending"
          :boardID="this.boardId"
        />
        <board-column
          title="Ready"
          :cards="ready"
          :boardID="this.boardId"
        />
        <board-column
          title="Completed"
          :cards="completed"
          :boardID="this.boardId"
        />
        <board-column
          title="Canceled"
          :cards="canceled"
          :boardID="this.boardId"
        />
      </div>
      </div>
  </div>
</template>