import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000",
});

export default {

    getBoards() {
        return http.get('/boards');
    },

    getPizzas(boardID) {
        return http.get(`/boards/${boardID}`);
    },

    getPizza(pizzaID) {
        return http.get(`/pizzas/${pizzaID}`)
      },
    
    getSpecialtyPizza() {
        return http.get('/pizzas/specialty');
    },

    createPizza(pizza) {
        return http.post('/pizzas', pizza);
    },

    deletePizza(pizzaID) {
        return http.delete(`/pizzas/${pizzaID}`); 
    },

    deleteBoard(boardID) {
        const authStr = 'Bearer ' + localStorage.getItem('token'); 
        return http.delete(`/boards/${boardID}`, { headers: { Authorization: authStr } })
      }

}