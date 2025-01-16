import React, { useState, useEffect } from "react";
import { motion, AnimatePresence } from "motion/react";
import { HiArrowRightEndOnRectangle } from "react-icons/hi2";
import { Section } from "./sections";
import { ActionButton } from "../../home/buttons";

interface Props {
  parentImage: React.ReactNode;
  visible: boolean;
  onClose: () => void;
}

const MainSnippet: React.FC<Props> = ({ parentImage, visible, onClose }) => {
  const [isVisible, setIsVisible] = useState(visible);

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
            className="fixed z-10 inset-0 bg-slate-500 bg-opacity-50 backdrop-blur-[2px]"
            onClick={handleClose}
          ></div>

          <motion.div
            className="fixed top-[calc((100vh-32rem)/2)] left-[calc((100vw-57rem)/2)] w-[57rem] h-[32rem] p-4 bg-containerGrey rounded-3xl shadow-lg z-50"
            initial={{ opacity: 0, y: -10 }}
            animate={{ opacity: 1, y: 0 }}
            exit={{ opacity: 0, y: -10 }}
            transition={{ duration: 0.3 }}
          >
            {/* <TbXboxXFilled
              className="absolute top-0 right-0 w-8 h-8"
              onClick={handleClose}
            /> */}
            <div className="grid grid-cols-2 justify-center items-center w-full h-full relative">
              <Section
                image={parentImage}
                button={
                  <ActionButton text="Registrati" bgColor="bg-buttonBlue" />
                }
              >
                Concludi la registrazione
              </Section>
              <div className="absolute left-1/2 transform -translate-x-1/2 h-full w-[1px] rounded-full bg-gray-600"></div>
              <Section
                image={<HiArrowRightEndOnRectangle className=" w-28 h-28" />}
                button={<ActionButton text="Procedi" bgColor="bg-white" />}
              >
                Procedi senza concludere la registrazione
              </Section>
            </div>
          </motion.div>
        </>
      )}
    </AnimatePresence>
  );
};

export default MainSnippet;
