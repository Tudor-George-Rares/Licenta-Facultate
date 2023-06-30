<template>
  <q-page-container>
    <q-page>
      <q-card class="q-ma-md" style="max-width: 400px; margin: auto">
        <q-card-section>
          <q-form @submit="login">
            <q-input
              v-model="username"
              label="Username"
              lazy-rules
              :rules="[(val) => !!val || 'Username is required']"
            />
            <q-input
              v-model="password"
              label="Password"
              lazy-rules
              :rules="[(val) => !!val || 'Password is required']"
              type="password"
            />
            <q-btn type="submit" label="Login" color="primary" />
          </q-form>
        </q-card-section>
      </q-card>
    </q-page>
  </q-page-container>
</template>

<script>
import { defineComponent, ref } from 'vue';
import { useAuthStore } from 'stores/useAuthStore';
import { useRouter } from 'vue-router';
export default defineComponent({
  setup() {
    const username = ref('');
    const password = ref('');
    const store = useAuthStore();
    const router = useRouter();

    const login = async () => {
      try {
        let response = await store.login(username.value, password.value);
        if (response.status === 200) {
          router.push('/');
        }
      } catch (error) {
        console.error(error);
      }
    };
    return {
      username,
      password,
      login,
    };
  },
});
</script>

<style></style>
