<template>
  <q-page-container>
    <div v-if="selectedProduct">
      <h1>{{ selectedProduct.name }}</h1>
      <p>{{ selectedProduct.description }}</p>
      <p>Price: {{ selectedProduct.price }}</p>
    </div>
    <div v-else>
      <p>No product selected</p>
    </div>
  </q-page-container>
</template>

<script>
export default {
  data() {
    return {
      selectedProduct: null,
      products: [
        {
          id: 1,
          name: 'Product 1',
          description: 'This is the first product',
          price: 10.99,
        },
        {
          id: 2,
          name: 'Product 2',
          description: 'This is the second product',
          price: 19.99,
        },
        {
          id: 3,
          name: 'Product 3',
          description: 'This is the third product',
          price: 5.99,
        },
      ],
    };
  },
  methods: {
    selectProduct(product) {
      this.selectedProduct = product;
    },
  },
};
</script>

<style></style>
