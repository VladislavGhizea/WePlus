import fetchWrapper from "../fetchWrapper";

interface NumeroTelefono {
  // Definisci qui le proprietà dell'interfaccia NumeroTelefono
  id?: number;
  numero: string;
  tipo: string;
}

// Recupera tutti i numeri di telefono
export const getAllNumeriTelefono = async (): Promise<NumeroTelefono[]> => {
  return (await fetchWrapper("/NumeriTelefono")) as NumeroTelefono[];
};

// Recupera un numero di telefono per ID
export const getNumeroTelefonoById = async (
  id: number
): Promise<NumeroTelefono> => {
  return (await fetchWrapper(`/NumeriTelefono/${id}`)) as NumeroTelefono;
};

// Crea un nuovo numero di telefono
export const createNumeroTelefono = async (
  numeroTelefono: NumeroTelefono
): Promise<NumeroTelefono> => {
  return (await fetchWrapper("/NumeriTelefono", {
    method: "POST",
    body: JSON.stringify(numeroTelefono),
  })) as NumeroTelefono;
};

// Aggiorna un numero di telefono esistente
export const updateNumeroTelefono = async (
  id: number,
  numeroTelefono: NumeroTelefono
): Promise<NumeroTelefono> => {
  return (await fetchWrapper(`/NumeriTelefono/${id}`, {
    method: "PUT",
    body: JSON.stringify(numeroTelefono),
  })) as NumeroTelefono;
};

// Elimina un numero di telefono
export const deleteNumeroTelefono = async (id: number): Promise<void> => {
  await fetchWrapper(`/NumeriTelefono/${id}`, {
    method: "DELETE",
  });
};
