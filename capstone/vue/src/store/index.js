import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    isBannerDisplayed: true,
    boards: [],
    activeBoardId: null,
    boardPizzas: [],
    pizza: {
      pizzaSize: '',
      dough: '',
      shape: '',
      sauceType: '',
      description: '',
      isAvailable: true,
      pizzaPrice: null,
      isSpecialty: false,
      status: ''
    }
  },
  mutations: {
    SET_BOARDS(state, data) {
      state.boards = data;
    },
    SET_ACTIVE_BOARD(state, boardId) {
      state.activeBoardId = boardId;
    },
    SET_BOARD_PIZZAS(state, data) {
      state.boardPizzas = data;
    },
    SET_CURRENT_PIZZA(state, data) {
      state.pizza = data;
    },
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    SET_BANNER_DISPLAY(state) {
      if (state.isBannerDisplayed === true) {
        state.isBannerDisplayed = false
      }
    }
  }
})
