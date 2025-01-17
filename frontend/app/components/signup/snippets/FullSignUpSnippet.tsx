import React, { useState, useEffect } from "react";
import { motion, AnimatePresence } from "motion/react";
import { ActionButton } from "../../home/buttons";
import { InputSection } from "./sections";
import { Fisiche } from "@/app/variables";
interface Props {
  width: string;
  height: string;
  parentImage: React.ReactNode;
  visible: boolean;
  onClose: () => void;
  parentText: string;
}
const FullSignUpSnippet: React.FC<Props> = ({
  width,
  height,
  parentImage,
  visible,
  onClose,
  parentText,
}) => {
  const [isVisible, setIsVisible] = useState(visible);
  const distanceTop = `calc((100vh - ${height}) / 2)`;
  const distanceLeft = `calc((100vw - ${width}) / 2)`;

  useEffect(() => {
    setIsVisible(visible);
  }, [visible]);

  const handleClose = () => {
    setIsVisible(false);
    onClose();
  };

  return (
    <AnimatePresence>
      {isVisible && (
        <>
          <div
            className="fixed z-[30] inset-0 bg-slate-500 bg-opacity-50 backdrop-blur-[2px]"
            onClick={handleClose}
          ></div>

          <motion.div
            className="fixed p-4 bg-containerGrey rounded-3xl shadow-lg z-[40]"
            style={{
              top: distanceTop,
              left: distanceLeft,
              width: width,
              height: height,
            }}
            initial={{ opacity: 0, y: -10 }}
            animate={{ opacity: 1, y: 0 }}
            exit={{ opacity: 0, y: -10 }}
            transition={{ duration: 0.3 }}
          >
            {/* <TbXboxXFilled
              className="absolute top-0 right-0 w-8 h-8"
              onClick={handleClose}
            /> */}
            <div className="flex h-[3rem] w-full justify center items-center">
              <div className="h-[3rem] w-[3rem] mr-4">{parentImage}</div>
              <h2 className="text-3xl">{parentText}</h2>
            </div>
            <div className="grid grid-cols-2 grid-rows-1">
              <InputSection
                className="mt-[2rem] mr-[4rem] ml-[4rem]"
                inputs={Fisiche.slice(0, Math.floor(Fisiche.length / 2) + 1)}
              />
              <InputSection
                className="mt-[2rem] mr-[4rem] ml-[4rem]"
                inputs={Fisiche.slice(
                  Math.floor(Fisiche.length / 2) + 1,
                  Fisiche.length
                )}
              />
            </div>
            <div className="flex items-center justify-end mt-[2.5rem]">
              <ActionButton text="Avanti" bgColor="bg-buttonBlue" />
            </div>
          </motion.div>
        </>
      )}
    </AnimatePresence>
  );
};

export default FullSignUpSnippet;
