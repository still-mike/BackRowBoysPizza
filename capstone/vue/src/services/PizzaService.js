import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000",
});

export default {

    getSpecialtyPizza() {
        return http.get('/pizzas/specialty');
    },

    createPizza(pizza) {
        return http.post('/pizzas', pizza);
    }

}