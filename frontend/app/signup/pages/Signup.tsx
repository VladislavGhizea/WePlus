import React from "react";
import { ActionButton, TextInput } from "../../components/home/buttons";
import { BackButton } from "../../components/signup/buttons";
interface Props {
  onNext: () => void;
}
const Signup: React.FC<Props> = ({ onNext }) => {
  return (
    <div className="flex justify-center items-center h-screen w-screen">
      <div className="h-[34.5rem] w-[26rem] bg-containerGrey grid grid-rows-5 gap-8 p-8 rounded-3xl shadow-xl">
        <TextInput text="Username" type="text" />
        <TextInput text="Email" type="email" />
        <TextInput text="Password" type="password" />
        <TextInput text="Conferma password" type="password" />
        <div className="flex justify-between">
          <BackButton />
          <ActionButton
            text="Registrati"
            bgColor=" bg-buttonBlue"
            onClick={onNext}
          />
        </div>
      </div>
    </div>
  );
};

export default Signup;
