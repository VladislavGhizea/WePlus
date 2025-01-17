import fetchWrapper from './fetchWrapper';

// Recupera tutti i numeri di telefono
export const getAllNumeriTelefono = async () => {
  return await fetchWrapper('/NumeriTelefono');
};

// Recupera un numero di telefono per ID
export const getNumeroTelefonoById = async (id) => {
  return await fetchWrapper(`/NumeriTelefono/${id}`);
};

// Crea un nuovo numero di telefono
export const createNumeroTelefono = async (numeroTelefono) => {
  return await fetchWrapper('/NumeriTelefono', {
    method: 'POST',
    body: JSON.stringify(numeroTelefono),
  });
};

// Aggiorna un numero di telefono esistente
export const updateNumeroTelefono = async (id, numeroTelefono) => {
  return await fetchWrapper(`/NumeriTelefono/${id}`, {
    method: 'PUT',
    body: JSON.stringify(numeroTelefono),
  });
};

// Elimina un numero di telefono
export const deleteNumeroTelefono = async (id) => {
  return await fetchWrapper(`/NumeriTelefono/${id}`, {
    method: 'DELETE',
  });
};
