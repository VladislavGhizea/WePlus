"use client";
import React, { useState, useCallback } from "react";
import { AiOutlineEye, AiOutlineEyeInvisible } from "react-icons/ai";
import classNames from "classnames";

interface Props {
  text: string;
  type: string;
  options?: string[];
  classNameContainer?: string;
  width?: string;
  height?: string;
}

const TextInput: React.FC<Props> = ({
  text,
  type,
  options,
  classNameContainer = "",
  width = "w-full",
  height = "h-[4.5rem]",
}) => {
  const [showPassword, setShowPassword] = useState(false);

  const togglePasswordVisibility = useCallback(() => {
    setShowPassword((prevShowPassword) => !prevShowPassword);
  }, []);

  const renderInput = () => {
    const inputClass = classNames(width, height, "rounded-2xl", "text-2xl", "px-[1rem]", "pr-[3rem]");
    
    switch (type) {
      case "select":
        return (
          <select className={inputClass} defaultValue="">
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
              className={inputClass}
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
            className={inputClass}
            placeholder={text}
            type={type}
          />
        );
    }
  };

  return (
    <div className={classNames("relative", classNameContainer)}>{renderInput()}</div>
  );
};

export default TextInput;