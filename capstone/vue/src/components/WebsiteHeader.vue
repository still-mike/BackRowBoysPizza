<template>
    <div>
        <div id = 'PromoBanner' v-if="isBannerDisplayed ===true">
            <div class = 'bannerExit'><button type ='button' class = 'bannerExit' v-on:click="changeBannerDisplay">x</button></div>
            <div class = "bannerText"><h1>use code 'brb15' for 15% off!</h1></div>
        </div>
        <div id = 'NavBar'>
            <nav>
                <router-link to="/contact-us" class='NavLink'>contact</router-link>
                <router-link to="/about-us" class='NavLink'>about us</router-link>
                <router-link to="/order-now" class='NavLink'>order now</router-link>
                <router-link to="/" class='NavLink'>home</router-link>
            </nav>
        </div>
    </div>
</template>

<script>
export default {
    name: "website-header", 
    computed: {
        isBannerDisplayed() {
            return this.$store.state.isBannerDisplayed
            
        }
    
    },
    methods: {
        changeBannerDisplay() {
            console.log(this.$store.state.isBannerDisplayed)
            this.$store.commit("SET_BANNER_DISPLAY");
        }
    }
}
</script>

<style>
#PromoBanner {
    justify-content: end;
    text-align: end;
    background-color: white;
    height: 100%;

}
.bannerExit {
    all: unset;
    cursor: pointer;

}
.bannerText {
    text-align: center;
    padding-bottom: .25rem;
    display: flow-root;
    font-size: 10px;
}
.bannerText h1 {
    margin-top: 0;

}
#NavBar {
    background-color: #B6D7BA;
    overflow: hidden;
    height: 50px;
  
}

.NavLink {
    color: white;
    text-decoration: none;
    padding: 15px;
    font-size: 30px;
    float: right;
    margin-left: 20px;
    margin-right: 10px;
    
}
.NavLink:hover {
    opacity: 0.7;
    color: #F76C4B;
}

</style>