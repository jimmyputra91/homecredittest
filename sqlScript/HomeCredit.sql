PGDMP     &    $            
    w            home_credit    12.0    12.0                 0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16393    home_credit    DATABASE     �   CREATE DATABASE home_credit WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';
    DROP DATABASE home_credit;
                postgres    false            �            1259    16394    user_module    TABLE     �   CREATE TABLE public.user_module (
    "ID" integer NOT NULL,
    "userID" character varying(20) NOT NULL,
    "moduleName" character varying(100) NOT NULL,
    "moduleOrder" integer NOT NULL,
    "activeStatus" boolean NOT NULL
);
    DROP TABLE public.user_module;
       public         heap    postgres    false            �
          0    16394    user_module 
   TABLE DATA           b   COPY public.user_module ("ID", "userID", "moduleName", "moduleOrder", "activeStatus") FROM stdin;
    public          postgres    false    202   -       ~
           2606    16398    user_module user_module_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.user_module
    ADD CONSTRAINT user_module_pkey PRIMARY KEY ("ID");
 F   ALTER TABLE ONLY public.user_module DROP CONSTRAINT user_module_pkey;
       public            postgres    false    202            �
   �   x�U��
�0����aē���ĕn�dT��@��h���|������j,��5=�����8��X���'8.���U�������� 068.�-�}Ri����\�ǔ��tA-tL,�()��,()�K�Xӿ*y_c���;�     