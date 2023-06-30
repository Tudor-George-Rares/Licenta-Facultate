<template>
  <q-page class="flex flex-start justify-center q-pa-xl">
    <q-card style="max-width: 800px; min-width: 400px; height: fit-content">
      <q-card-section>
        <q-toolbar>
          <q-toolbar-title>Autentificare</q-toolbar-title>
        </q-toolbar>
      </q-card-section>
      <q-card-section>
        <q-form @submit="login">
          <q-input
            v-model="username"
            label="Utilizator"
            lazy-rules
            :rules="[(val) => !!val || 'Utilizator-ul este necesar']"
          />
          <q-input
            v-model="password"
            label="Parola"
            lazy-rules
            :rules="[
              (val) => !!val || 'Parola este necesara',
              (val) =>
                (val && val.length >= 8) ||
                'Parola trebuie sa contina cel putin 8 caractere',
            ]"
            type="password"
          />
          <q-btn
            label="Du-ma la inregistrare"
            color="primary"
            flat
            class="q-mt-md"
            @click="redirectRegister"
          />
          <q-btn
            type="submit"
            label="Inregistrare"
            color="primary"
            class="q-mt-md q-ml-xl"
          />
        </q-form>
      </q-card-section>
    </q-card>
  </q-page>
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
    const redirectRegister = () => {
      router.push('/register');
    };
    return {
      username,
      password,
      redirectRegister,
      login,
    };
  },
});
</script>

<style></style>
