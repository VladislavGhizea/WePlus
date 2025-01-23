import React, { useState } from "react";
import { ActionButton, TextInput } from "./buttons";
import { login } from "../../api/user";

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const handleLogin = (event: React.MouseEvent<HTMLButtonElement>) => {
    event.preventDefault();
    login(username, password);
  };

  const handleSignup = (event: React.MouseEvent<HTMLButtonElement>) => {
    event.preventDefault();
    console.log("Signup button clicked");
    // Aggiungi qui la logica per la registrazione
  };

  return (
    <div className="flex justify-center">
      <form action="" method="get" className="flex flex-col mt-[3.5rem]">
        <div>
          <TextInput
            text="Username"
            type="text"
            classNameContainer="w-[21.5rem]"
            value={username}
            onChange={(e: React.ChangeEvent<HTMLInputElement>) =>
              setUsername(e.target.value)
            }
          />
        </div>
        <div className="mt-[2rem]">
          <TextInput
            text="Password"
            type="password"
            classNameContainer="w-[21.5rem]"
            value={password}
            onChange={(e: React.ChangeEvent<HTMLInputElement>) =>
              setPassword(e.target.value)
            }
          />
        </div>
        <div className="mt-[1rem] flex justify-center">
          <a href="#" className="text-[#3BA5F0]">
            Hai dimenticato le credenziali?
          </a>
        </div>
        <div className="mt-[2rem] flex flex-row">
          <ActionButton text="Accedi" onClick={handleLogin} />
          <div className="flex justify-center items-center">
            <p className="mx-[1.75rem] text-2xl">o</p>
          </div>
          <ActionButton
            text="Registrati"
            bgColor="bg-buttonBlue"
            linkTo="signup"
          />
        </div>
      </form>
    </div>
  );
};

export default Login;
