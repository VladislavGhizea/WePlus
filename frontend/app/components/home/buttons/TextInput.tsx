"use client";
import React, { useState } from "react";
import { AiOutlineEye, AiOutlineEyeInvisible } from "react-icons/ai";

interface Props {
  text: string;
  type: string;
  options?: string[];
  classNameContainer?: string;
}

const TextInput: React.FC<Props> = ({
  text,
  type,
  options,
  classNameContainer = "",
}) => {
  const [showPassword, setShowPassword] = useState(false);

  const togglePasswordVisibility = () => {
    setShowPassword(!showPassword);
  };

  const renderInput = () => {
    switch (type) {
      case "select":
        return (
          <select
            className="w-full h-[4.5rem] rounded-2xl text-2xl px-[1rem] pr-[3rem]"
            defaultValue=""
          >
            <option value="" disabled>
              {text}
            </option>
            {options?.map((option, index) => (
              <option key={index} value={option}>
                {option}
              </option>
            ))}
          </select>
        );
      case "checkbox":
        return (
          <div className="flex items-center">
            <input type="checkbox" className="mr-2" />
            <label className="text-2xl">{text}</label>
          </div>
        );
      case "password":
        return (
          <>
            <input
              className="w-full h-[4.5rem] rounded-2xl text-2xl px-[1rem] pr-[3rem]"
              placeholder={text}
              type={showPassword ? "text" : "password"}
            />
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
          </>
        );
      default:
        return (
          <input
            className="w-full h-[4.5rem] rounded-2xl text-2xl px-[1rem] pr-[3rem]"
            placeholder={text}
            type={type}
          />
        );
    }
  };

  return (
    <div className={`relative ${classNameContainer}`}>{renderInput()}</div>
  );
};

export default TextInput;
