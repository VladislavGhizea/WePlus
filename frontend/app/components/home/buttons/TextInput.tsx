"use client";
import { AiOutlineEye, AiOutlineEyeInvisible } from "react-icons/ai";
import React, { useState } from "react";

interface Props {
  text: string;
  type: string;
  classNameContainer?: string;
}

const TextInput: React.FC<Props> = ({ text, type, classNameContainer }) => {
  const [showPassword, setShowPassword] = useState(false);
  classNameContainer = classNameContainer || "";

  const togglePasswordVisibility = () => {
    setShowPassword(!showPassword);
  };

  return (
    <div className={"relative " + classNameContainer}>
      <input
        className="w-full h-[4.5rem] rounded-2xl text-2xl px-[1rem] pr-[3rem]"
        placeholder={text}
        type={type === "password" && !showPassword ? "password" : "text"}
      />
      {type === "password" && (
        <div
          className="absolute right-[1rem] top-1/2 transform -translate-y-1/2 cursor-pointer"
          onClick={togglePasswordVisibility}
        >
          {showPassword ? (
            <AiOutlineEye className="w-[1.5rem] h-[1.5rem]" />
          ) : (
            <AiOutlineEyeInvisible className="w-[1.5rem] h-[1.5rem]" />
          )}
        </div>
      )}
    </div>
  );
};

export default TextInput;
