import React, { useEffect, useState } from "react";
import { Individuale, Giuridica, Fisica } from "@/app/variables";
import Container from "./Container";

interface Props {
  tipo: "FISICA" | "GIURIDICA" | "INDIVIDUALE" | "ADMIN";
}


const getAllUsers = async (tipo: string): Promise<object[]> => {
  let urls: string[] = [];
  switch (tipo) {
    case "FISICA":
      urls = ["/personeGiuridiche"];
      break;
    case "GIURIDICA":
      urls = ["/personeFisiche"];
      break;
    case "INDIVIDUALE":
      urls = ["/personeFisiche", "/personeGiuridiche"];
      break;
    case "ADMIN":
      throw new Error("NON IMPLEMENTATO"); 
      break;
    default:
      throw new Error("Tipo di utente non valido");
  }

  try {
    const responses = await Promise.all(urls.map(url => fetch(url)));
    const data = await Promise.all(responses.map(response => {
      if (!response.ok) {
        throw new Error("Errore nel recupero degli utenti");
      }
      return response.json();
    }));
    return data.flat();
  } catch (error) {
    console.error(error);
    throw new Error("Errore nel recupero degli utenti");
  }
};

const ContainerCreator: React.FC<Props> = ({ tipo }) => {
  const [users, setUsers] = useState<object[]>([]);

  useEffect(() => {
    const fetchUsers = async () => {
      try {
        const data = await getAllUsers(tipo);
        let mappedData;
        switch (tipo) {
          case "FISICA":
            mappedData = data.map(item => new Fisica(item));
            break;
          case "GIURIDICA":
            mappedData = data.map(item => new Giuridica(item));
            break;
          case "INDIVIDUALE":
            mappedData = data.map(item => new Individuale(item));
            break;
          case "ADMIN":
            mappedData = data; // Gestire la mappatura per gli utenti admin se necessario
            break;
          default:
            mappedData = data;
        }
        setUsers(mappedData);
      } catch (error) {
        console.error(error);
      }
    };

    fetchUsers();
  }, [tipo]);

  return (
    <div className="overflow-y-auto h-full">
      {users.map((user, i) => (
        <Container key={i} user={user} />
      ))}
    </div>
  );
};

export default ContainerCreator;