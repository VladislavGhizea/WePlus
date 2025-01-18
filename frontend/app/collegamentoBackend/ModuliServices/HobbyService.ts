import fetchWrapper from '../fetchWrapper';

interface Hobby {
  // Definisci qui le proprietà dell'interfaccia Hobby
  id?: number;
  nome: string;
  descrizione?: string;
}

// Recupera tutti gli hobby
export const getAllHobby = async (): Promise<Hobby[]> => {
  return await fetchWrapper('/Hobby') as Hobby[];
};

// Recupera un hobby per ID
export const getHobbyById = async (id: number): Promise<Hobby> => {
  return await fetchWrapper(`/Hobby/${id}`) as Hobby;
};

// Crea un nuovo hobby
export const createHobby = async (hobby: Hobby): Promise<Hobby> => {
  return await fetchWrapper('/Hobby', {
    method: 'POST',
    body: JSON.stringify(hobby),
  }) as Hobby;
};

// Aggiorna un hobby esistente
export const updateHobby = async (id: number, hobby: Hobby): Promise<Hobby> => {
  return await fetchWrapper(`/Hobby/${id}`, {
    method: 'PUT',
    body: JSON.stringify(hobby),
  }) as Hobby;
};

// Elimina un hobby
export const deleteHobby = async (id: number): Promise<void> => {
  await fetchWrapper(`/Hobby/${id}`, {
    method: 'DELETE',
  });
};