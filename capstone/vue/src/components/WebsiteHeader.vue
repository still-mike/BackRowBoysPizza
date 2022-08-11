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

</style>