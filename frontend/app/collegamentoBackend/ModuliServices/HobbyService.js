import fetchWrapper from './fetchWrapper';

// Recupera tutti gli hobby
export const getAllHobby = async () => {
  return await fetchWrapper('/Hobby');
};

// Recupera un hobby per ID
export const getHobbyById = async (id) => {
  return await fetchWrapper(`/Hobby/${id}`);
};

// Crea un nuovo hobby
export const createHobby = async (hobby) => {
  return await fetchWrapper('/Hobby', {
    method: 'POST',
    body: JSON.stringify(hobby),
  });
};

// Aggiorna un hobby esistente
export const updateHobby = async (id, hobby) => {
  return await fetchWrapper(`/Hobby/${id}`, {
    method: 'PUT',
    body: JSON.stringify(hobby),
  });
};

// Elimina un hobby
export const deleteHobby = async (id) => {
  return await fetchWrapper(`/Hobby/${id}`, {
    method: 'DELETE',
  });
};
