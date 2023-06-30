<template>
  <q-page class="row items-center justify-evenly">
    VERIFICARE: {{ computedResponse }}
  </q-page>
</template>

<script lang="ts">
import { computed, onMounted, defineComponent, ref } from 'vue';
import { api } from 'boot/axios';

export default defineComponent({
  name: 'IndexPage',
  components: {},
  setup() {
    const responseRef = ref(null);
    onMounted(async () => {
      console.log('mounted');
      responseRef.value = await call();
      console.log(responseRef.value);
    });
    const call = async () => {
      let response = await api.get('/test/admin');
      console.log('response: ', response);
      console.log(response.data);
      console.log(response.status);
      if (response.status === 200) {
        return response.data;
      } else {
        return 'error';
      }
    };

    const computedResponse = computed(() => {
      return responseRef.value;
    });
    return { computedResponse };
  },
});
</script>
